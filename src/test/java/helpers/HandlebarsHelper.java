package helpers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HandlebarsHelper {

	public String handlebarsify(String animal, String message) {
		Handlebars handlebars = new Handlebars();
		Template template;
		String result = "";
		try {
			template = handlebars.compileInline(message);

			result = template.apply(animal);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return String.valueOf(result);
	}

	public String handlebarsify(String animal, String name, String message) {
		Handlebars handlebars = new Handlebars();
		Template template;
		String result = "";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("animal", animal);
		map.put("name", name);

		try {
			template = handlebars.compileInline(message);

			result = template.apply(map);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return String.valueOf(result);
	}

}
