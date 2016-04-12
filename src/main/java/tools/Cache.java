package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Cache<T> {

	private String path;

	public Cache(String path, TypeToken type) {
		this.path = path;
	}

	public void save(T data) throws FileNotFoundException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter pw = new PrintWriter(path);
		pw.write(gson.toJson(data));
		pw.close();
	}

	public T load() throws IOException {
		T r = null;
		BufferedReader br = new BufferedReader(new FileReader(path));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		r = gson.fromJson(br, new TypeToken<T>() {
			
		}.getType());
		br.close();

		return r;
	}

}
