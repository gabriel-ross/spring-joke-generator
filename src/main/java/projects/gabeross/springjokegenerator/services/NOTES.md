* The reason we create an interface and then implementation is because
  for the controller it is best practice to code against an interface
  and then create an implementation of that interface that spring can inject for us.
  This better abides by the SOLID principle of encapsulation (and another one that I'm blanking on - I think
  it's the inversion of control/dependency one).

* In this project I think the services take the place of the models, as we're not mapping data
  to a database. The service is instead just hard-coded functionality we want in our program.
  Instead of returning data from a database in the form of an object.