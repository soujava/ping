package sh.platform.template;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("")
@RequestScoped
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    public Response doGet() throws UnknownHostException {
        final InetAddress host = InetAddress.getLocalHost();
        final String hostName = host.getHostName();
        final String hostAddress = host.getHostAddress();
        String message = "hello from Platform.sh from IP: " + hostAddress + " name: " + hostName;

        CacheControl cc = new CacheControl();
        cc.setMaxAge(0);
        cc.setNoCache(true);
        cc.setPrivate(true);
        return Response.ok(message).cacheControl(cc).build();
    }
}