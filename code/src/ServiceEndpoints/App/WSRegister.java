package ServiceEndpoints.App;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Author: Tobias
 * Date: 17.10.2015
 * Time: 16:11
 */
@Path("/register")
public class WSRegister {

    @GET
    @Path("/username/{usr}/password/{pw}/deviceid/{devid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String register(@DefaultValue("") @PathParam("usr") String usr,@DefaultValue("") @PathParam("pw") String pw,
                           @DefaultValue("") @PathParam("devid") String deviceID) {

        JSONObject rs = new JSONObject();

        try {
            rs.append("success",true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rs.toString();


    }
}
