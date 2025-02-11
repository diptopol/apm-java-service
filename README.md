## A Sample java application to replicate Elastic APM Issue

- The sample request url is http://localhost:8090/service-a/message. This request will flow as gateway service -> serviceA -> serviceB.
- The trace.id is available in the logfiles that will be available under <I>app_logs<I> directory. 
- The issue is that the generated trace id is not same for all the services.