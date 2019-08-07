package sh.platform.template;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("")
@RequestScoped
public class HelloWorldResource {

    @GET
    @Produces("text/plain")
    public String doGet() throws UnknownHostException {
        return "hello from Platform.sh from IP:" + InetAddress.getLocalHost();
    }
}