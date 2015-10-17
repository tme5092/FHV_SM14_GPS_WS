package ServiceEndpoints.App;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jvnet.jax_ws_commons.json.JSONBindingID;

import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingType;
import java.util.HashSet;

/**
 * Author: Tobias
 * Date: 17.10.2015
 * Time: 13:32
 */
@Path("userExists")
@BindingType(JSONBindingID.JSON_BINDING)
public class WSUserExists {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String check(@WebParam(name="username")String username) {
        return "Hello World: "+ username;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/username/{usr}")
    public String checkJson(@DefaultValue("") @PathParam("usr") String usr) {
        JSONObject loginObject = new JSONObject();

        HashSet<String> users = new HashSet<>();
        users.add("phe");

        try {
            boolean isKnown = users.contains(usr);
            loginObject.append("exists",isKnown);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  loginObject.toString();
    }

}
