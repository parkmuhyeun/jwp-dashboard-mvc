package nextstep.mvc.view;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        String jsonResult = convertMap(model);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(OBJECT_MAPPER.writeValueAsString(model));
    }

    private String convertMap(Map<String, ?> model) throws JsonProcessingException {
        if (model.size() > 1) {
            return OBJECT_MAPPER.writeValueAsString(model);
        }

        return OBJECT_MAPPER.writeValueAsString(model.values().toArray()[0]);
    }
}
