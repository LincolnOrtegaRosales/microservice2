package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/m2-lincoln")
@RequiredArgsConstructor
public class GenericController {

    @GetMapping("")
    public ResponseEntity<?> getFirstMethod(HttpServletRequest request) throws MalformedURLException {

        URL url = new URL(request.getRequestURL().toString());
        String host  = url.getHost();
        String userInfo = url.getUserInfo();
        String scheme = url.getProtocol();
        int port = url.getPort();

        try {
            return new ResponseEntity<>(
                    "Response from : m2-lincoln , host: " + host
                            + ", port: " + port
//                            + ", userInfo: " + userInfo
                            + ", scheme: " + scheme + ",",
                    HttpStatus.OK);
        } catch (Exception e) {
            return errorResponse();
        }
    }

    private ResponseEntity<String> errorResponse(){
        return new ResponseEntity<>("Something went wrong :(", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<String> noScrumFoundResponse(Long id){
        return new ResponseEntity<>("No data found with id: " + id, HttpStatus.NOT_FOUND);
    }
}
