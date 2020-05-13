package it.caoxin.tdd.in.action.task6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/13
 * 功能描述:
 * 修改日期:2020/5/13
 * 修改描述:
 */
public class Schema1 {

    private String schemaText;
    private List<Arguement> argsTypes;

    public Schema1(String schemaText) {
        this.schemaText = schemaText;
        parseArgsType();
    }

    private void parseArgsType() {
        argsTypes = Stream
                .of(schemaText.split(" "))
                .map(str->new Arguement(str))
                .collect(Collectors.toList());
    }

    public int size() {
        return argsTypes.size();
    }


    public void parse(String[] params) {
        for (int i = 0; i < params.length; i += 2) {
            String label = params[i].replace("-", "");
            Arguement arguement = argsTypes.stream().filter(arg -> arg.label().equals(label)).findAny().get();
            if ("Boolean".equals(arguement.type())) {
                arguement.value = parseBoolean(params[i+1]);
            } else if ("Integer".equals(arguement.type())) {
                arguement.value = parseInt(params[i+1]);
            }else {
                arguement.value = params[i+1];
            }
        }
    }

    public Object isOf(String command) {
        return argsTypes.
                stream().
                filter(arg -> arg.label().equals(command)).
                findAny().map(Arguement::value).
                get();
    }
}
