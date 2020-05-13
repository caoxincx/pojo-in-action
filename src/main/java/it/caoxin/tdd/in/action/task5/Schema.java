package it.caoxin.tdd.in.action.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2020/5/12
 * 功能描述:
 * 修改日期:2020/5/12
 * 修改描述:
 */
public class Schema {
    public static final String ARG_TYPES = "-l:Boolean -p:Integer -d:String";
    private HashMap<String, String> argTypeMap = new HashMap();

    public Schema() {
        String[] args = ARG_TYPES.split(" ");
        for (String arg : args) {
            String[] argAndType = arg.split(":");
            argTypeMap.put(argAndType[0], argAndType[1]);
        }
    }

    public String getArg(String arg) {
        return argTypeMap.get(arg);
    }

    public Map<String, Object> explain(String command) {
        String[] args = command.split(" ");
        Map<String,Object> argsMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            String type = argTypeMap.get(args[i]);
            if (type == null) continue;
            else {
                if ("Boolean".equals(type)) {
                    argsMap.put(args[i], Boolean.TRUE);
                } else if ("Integer".equals(type)) {
                    argsMap.put(args[i], Integer.parseInt(args[i + 1]));
                } else if ("String".equals(type)) {
                    argsMap.put(args[i], args[i + 1]);
                }
            }
        }
        return argsMap;
    }
}
