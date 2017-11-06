class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/api/merge" (controller: "mailMerge", action: "merge", parseRequest: true)
		"/api/mergePDF" (controller: "mailMerge", action: "mergePDF", parseRequest: true)
		"/api/mergeSave" (controller: "mailMerge", action: "mergeSave", parseRequest: true)
		"/api/template/$id/render-form" (controller:"templates", action: "renderMergeForm", parseRequest: true)
		"/api/batch" (resources: "batch", parseRequest: true)
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
