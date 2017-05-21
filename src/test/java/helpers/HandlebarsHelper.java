package helpers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import java.io.IOException;

public class HandlebarsHelper {

	public String handlebarsify(String animal, String message) {
		Handlebars handlebars = new Handlebars();
		Template template = null;
		String result = "";
		try {
			template = handlebars.compileInline(message);

			result = template.apply(animal);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return String.valueOf(result);
	}
}
