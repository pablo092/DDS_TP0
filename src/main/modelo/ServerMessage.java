package main.modelo;

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
