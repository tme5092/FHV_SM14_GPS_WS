package ServiceEndpoints.App;

import javax.ws.rs.GET;
import java.util.Calendar;

/**
 * Author: Tobias
 * Date: 17.10.2015
 * Time: 11:40
 */
@javax.ws.rs.Path("/Login")
public class WSLogin {

    @GET
    public String getServerTime() {
        return Calendar.getInstance().toString();
    }

}
