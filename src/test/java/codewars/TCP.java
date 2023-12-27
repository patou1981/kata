package codewars;

import java.util.HashMap;
import java.util.Map;

public class TCP {
    public static String traverseStates(String[] events) {
        Map<String, String> transitions = initializeTransitions();

        String currentState = "CLOSED";

        for (String event : events) {
            String nextState = transitions.get(currentState + "_" + event);
            if (nextState == null) {
                return "ERROR";
            }
            currentState = nextState;
        }

        return currentState;
    }

    private static Map<String, String> initializeTransitions() {
        Map<String, String> transitions = new HashMap<>();

        // Define state transitions
        transitions.put("CLOSED_APP_ACTIVE_OPEN", "SYN_SENT");
        transitions.put("CLOSED_APP_PASSIVE_OPEN", "LISTEN");
        transitions.put("LISTEN_RCV_SYN", "SYN_RCVD");
        transitions.put("LISTEN_APP_SEND", "SYN_SENT");
        transitions.put("LISTEN_APP_CLOSE", "CLOSED");
        transitions.put("SYN_RCVD_APP_CLOSE", "FIN_WAIT_1");
        transitions.put("SYN_RCVD_RCV_ACK", "ESTABLISHED");
        transitions.put("SYN_SENT_RCV_SYN_ACK", "ESTABLISHED");
        transitions.put("SYN_SENT_RCV_SYN", "SYN_RCVD");
        transitions.put("SYN_SENT_APP_CLOSE", "CLOSED");
        transitions.put("ESTABLISHED_APP_CLOSE", "FIN_WAIT_1");
        transitions.put("ESTABLISHED_RCV_FIN", "CLOSE_WAIT");
        transitions.put("FIN_WAIT_1_RCV_FIN", "CLOSING");
        transitions.put("FIN_WAIT_1_RCV_FIN_ACK", "TIME_WAIT");
        transitions.put("CLOSING_RCV_ACK", "TIME_WAIT");
        transitions.put("FIN_WAIT_1_APP_CLOSE", "CLOSING");
        transitions.put("TIME_WAIT_APP_TIMEOUT", "CLOSED");
        transitions.put("CLOSE_WAIT_APP_CLOSE", "LAST_ACK");
        transitions.put("LAST_ACK_RCV_ACK", "CLOSED");

        return transitions;
    }
}
