package main.model;

import org.json.JSONException;
import org.json.JSONObject;


public class JSONServerMessage extends JSONObject implements ServerMessage
{
    protected Exception exception;

    public JSONServerMessage()
    {
        super();
    }

    public JSONServerMessage(String stringToConvert) throws JSONException
    {
        super(stringToConvert);
    }

    public boolean putObject(String name, Object value)
    {
        try
        {
            super.put(name, value);
            this.clearException();
            return true;
        }
        catch(JSONException exception)
        {
            this.exception = exception;
            return false;
        }
    }

    public boolean hasKey(String name)
    {
        this.clearException();
        return super.has(name);
    }

    public Object getObjectFromKey(String name)
    {
        this.clearException();
        try
        {
            return super.get(name);
        }
        catch(JSONException exception)
        {
            this.exception = exception;
            return null;
        }
    }

    public int getIntFromKey(String name)
    {
        this.clearException();
        try
        {
            return super.getInt(name);
        }
        catch(JSONException exception)
        {
            this.exception = exception;
            return 0;
        }
    }

    public String getStringFromKey(String name)
    {
        this.clearException();
        try
        {
            return super.getString(name);
        }
        catch(JSONException exception)
        {
            this.exception = exception;
            return null;
        }
    }

    public ServerMessage getServerMessageFromKey(String name)
    {
        this.clearException();
        try
        {
            return this.getJSONObject(name);
        }
        catch(JSONException exception)
        {
            this.exception = exception;
            return null;
        }
    }




    public JSONServerMessage getJSONObject(String name) throws JSONException
    {
        Object object = this.get(name);
        if(object instanceof JSONServerMessage)
        {
            return (JSONServerMessage)object;
        }
        else if(object instanceof JSONObject)
        {
            return new JSONServerMessage(object.toString());
        }
        else
        {
            throw new JSONException("Object is not JSONServerMessage");
        }
    }


    public String toString()
    {
        return super.toString();
    }

    public JSONServerMessage fromString(String stringToConvert)
    {
        try
        {
            JSONServerMessage serverMessage = new JSONServerMessage(stringToConvert);
            return serverMessage;
        }
        catch(JSONException exception)
        {
            JSONServerMessage serverMessage = new JSONServerMessage();
            serverMessage.putObject("decoding_error", true);
            return serverMessage;
        }
    }


    protected void clearException()
    {
        this.exception = null;
    }

}
