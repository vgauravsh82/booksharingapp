(ns booksharingapp.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [booksharingapp.core-test]))

(doo-tests 'booksharingapp.core-test)

