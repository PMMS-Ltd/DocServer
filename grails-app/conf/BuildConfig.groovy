grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://maven.alfresco.com/nexus/content/groups/public/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.27'
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.core:0.9.8'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.document:0.9.8'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.document.docx:0.9.8'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.converter:0.9.8'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.template.freemarker:0.9.8'
		//compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.template.velocity:0.9.8'
		//compile 'org.xhtmlrenderer:flying-saucer-pdf:9.0.6'
		
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.core:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.document:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.document.docx:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.converter:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.converter.docx.xwpf:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.template.freemarker:1.0.5'
		compile 'fr.opensagres.xdocreport:fr.opensagres.xdocreport.template.velocity:1.0.5'
		compile 'org.xhtmlrenderer:flying-saucer-pdf:9.0.7'
		 //compile 'org.xhtmlrenderer:core-renderer:R8pre2'
		// compile 'com.lowagie:itext:2.1.7'
		 compile ('org.docx4j:docx4j:3.2.1') {excludes "slf4j-log4j12", "xml-apis", "commons-logging"}
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-commons-api:0.10.0', {
			 excludes 'slf4j-api'
		 }
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-commons-impl:0.10.0', {
			 excludes 'slf4j-api'
		 }
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-client-api:0.10.0', {
			 excludes 'slf4j-api'
		 }
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-client-impl:0.10.0', {
			 excludes 'log4j', 'slf4j-api', 'slf4j-log4j12'
		 }
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-client-bindings:0.10.0', {
			 excludes 'log4j', 'slf4j-api', 'slf4j-log4j12'
		 }
		 compile 'org.apache.chemistry.opencmis:chemistry-opencmis-server-support:0.10.0', {
			 excludes 'servlet-api', 'slf4j-api'
		 }
		 // Alfresco CMIS extension
		 compile 'org.alfresco.cmis.client:alfresco-opencmis-extension:0.7'
		
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.52.1"

        // plugins for the compile step
        compile ":scaffolding:2.0.3"
        compile ':cache:1.1.2'

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:3.6.10.13" // or ":hibernate4:4.3.5.1"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.0.2"
        runtime ":resources:1.2.7"
		compile ":rest-client-builder:2.0.3"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"

        // An alternative to the default resources plugin is the asset-pipeline plugin
        //compile ":asset-pipeline:1.6.1"

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.5.5"
        //compile ":less-asset-pipeline:1.5.3"
        //compile ":coffee-asset-pipeline:1.5.0"
        //compile ":handlebars-asset-pipeline:1.3.0.1"
		//compile ':cxf:2.0.1'
    }
}
