package nextstep.mvc.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import nextstep.web.support.MediaType;

public class JsonView implements View {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void render(final Map<String, ?> model, final HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        final String body = OBJECT_MAPPER.writeValueAsString(objectForBody(model));
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(body);
    }

    private Object objectForBody(final Map<String, ?> model) {
        if (model.size() != 1) {
            return model;
        }

        return model.values().stream()
                .findFirst()
                .orElseThrow();
    }
}
