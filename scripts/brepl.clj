(require
  '[cljs.build.api :as b]
  '[cljs.repl :as repl]
  '[cljs.repl.browser :as browser])

(b/build "src"
  {:output-dir "out"
   :modules {:moduleb {:output-to "out/moduleb.js"
                       :entries #{'mies.moduleb}}
             :core {:output-to "out/core.js"
                    :entries #{'mies.core}}}
   :optimizations :none
   :verbose true                 
   :source-map true})

(repl/repl (browser/repl-env)
  :output-dir "out")
