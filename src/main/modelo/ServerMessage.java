package main.modelo;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Objects;

public interface ServerMessage
{
    public boolean       putObject(String name, Object value);
    public boolean       hasKey(String name);
    public Object        getObjectFromKey(String name);
    public int           getIntFromKey(String name);
    public String        getStringFromKey(String name);
    public ServerMessage getServerMessageFromKey(String name);
    public String        toString();
    public ServerMessage fromString(String stringToConvert);
}
