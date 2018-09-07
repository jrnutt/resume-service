# Resume Service

This is a simple microservice that does one thing, fetches a resume in markdown format and serves a copy as either markdown, HTML, docx or PDF. HTML and PDF conversions are handled in Java, while docx conversions are currently handled by pandoc. If pandoc is not available, an http 503 will be returned.
