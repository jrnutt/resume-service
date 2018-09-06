;;
;; JDEE gradle project file for resume-service
;;

(require 'jdee-gradle)

(jdee-gradle-set-project "resume-service" "/home/jim/Source/resume-service" t)

;; Load the generated prj file, if it exists
(if (not (load (expand-file-name "prj-generated" jdee-gradle-project-root) t))
    ;; It wasn't found, so set some defaults
    (jdee-set-variables
     `(jdee-sourcepath '("./src/main/java" "./src/test/java"))
     `(jdee-build-class-path '("./build/classes/java/main" "./build/classes/java/test"))
     `(jdee-global-classpath '("./build/classes/java/main" "./build/classes/java/test"))
     ))

(jdee-set-variables
 `(jdee-jdk-doc-url ,(format "http://docs.oracle.com/javase/%s/docs/api/index.html" (jdee-java-minor-version)))
 `(jdee-compile-option-directory ,(let ((src-file (buffer-file-name)))
                                    (if (and src-file (string-match-p "/test/" src-file))
                                        "./build/classes/java/test"
                                      "./build/classes/java/main")))
 `(jdee-help-docsets '(("resume-service" ,(concat "file://" (expand-file-name "build/docs/javadoc" jdee-gradle-project-root)) nil)
                       (nil ,(format "http://docs.oracle.com/javase/%s/docs/api" (jdee-java-minor-version))
                            ,(format "1.%s" (jdee-java-minor-version)))
                       ))
 `(jdee-run-working-directory ,jdee-gradle-project-root)
 )

;;
;; Add other settings here
;;

