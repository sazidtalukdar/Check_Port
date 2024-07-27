package com.example.Port.Check;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.Socket;

@RestController
@CrossOrigin(origins = "*")
public class PortCheckController {

    @PostMapping("/check-port")
    public ResponseEntity<PortCheckResponse> checkPort(@RequestBody PortCheckRequest request) {
        boolean isPortOpen = isPortOpen(request.getHost(), request.getPort());
        return ResponseEntity.ok(new PortCheckResponse(isPortOpen));
    }

    private boolean isPortOpen(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static class PortCheckRequest {
        private String host;
        private int port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}
