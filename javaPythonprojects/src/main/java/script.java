import org.apache.commons.io.FileUtils;

import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


public class script
{
    public static void main (String args[]) throws
        ScriptException,
        NoSuchMethodException,
        IOException
    {
        StringWriter stringWriter = new StringWriter();
        ScriptContext scriptContext = new SimpleScriptContext();
        scriptContext.setWriter(stringWriter);
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("python");


        engine.eval(FileUtils.readFileToString(new File("/Users/i506644/Documents/javaPythonprojects/src/main/java/pythonFunction.txt")));


        // create an Invocable object by casting the script engine object
        Invocable inv = (Invocable) engine;

        String bids = FileUtils.readFileToString(new File("/Users/i506644/Documents/javaPythonprojects/src/main/java/bids.json"));

        inv.invokeFunction("printJson", bids);



}
}
