package my_minor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@SpringBootApplication  //does the work of the above 2 plus controller
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer=new TilesConfigurer();
		
		//tell tiles what configuration to use 
		String[] defs= {"/WEB-INF/tiles.xml"};
		
		//setting the definition for the configurer for tiles.xml
		tilesConfigurer.setDefinitions(defs);
		
		
		return tilesConfigurer;
	}

	@Bean //tells Spring that this object should be considered a bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver=new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
}
