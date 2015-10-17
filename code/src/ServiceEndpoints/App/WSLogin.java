package ServiceEndpoints.App;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Tobias
 * Date: 17.10.2015
 * Time: 11:40
 */
@javax.ws.rs.Path("/login")
public class WSLogin {

    @GET
    @Path("/username/{usr}/password/{pw}/deviceid/{devid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@DefaultValue("") @PathParam("usr") String usr,@DefaultValue("") @PathParam("pw") String pw,@DefaultValue("") @PathParam("devid") String deviceID) {

        /**
         * Map containing Login/Pw
         */
        Map<String,String> userDefs = new HashMap<>();
        userDefs.put("phe","phe");

        JSONObject rs = new JSONObject();

        boolean isSuccessfull = userDefs.containsKey(usr);
        if ( isSuccessfull ) {
            isSuccessfull = userDefs.get(usr).equals(pw);
        }

        try {
            rs.append("success",isSuccessfull);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rs.toString();
    }

}
