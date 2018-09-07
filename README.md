# Resume Service

This is a simple microservice that does one thing, fetches a resume in
markdown format and serves a copy as either markdown, HTML, docx or
PDF. It uses the
[vsch/flexmark-java](https://github.com/vsch/flexmark-java) libraries
to handle the HTML and PDF conversions. Docx and other future formats
are handled currently by using [pandoc](https://pandoc.org) in the
background to do the conversion. If pandoc is not available, an HTTP 501 status code is returned.

It's based on SpringBoot and built with gradle. It's more a proof of concept than anything.

## Issues and Future Features
  + As of right now, the path for the resume to be served is fixed, it needs to be a property.
  + The path for pandoc needs to be a property.
  + Support for any format pandoc supports would be good.
  + Move the format type into a parameter instead of basing it on the request suffix.
  + Added a docker image for easy deployment.
