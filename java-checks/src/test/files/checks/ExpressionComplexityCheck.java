class A {
  int a = false ? (true ? (false ? 1 : 0) : 0) : 1;                   
  int b = false ? (true ? (false ? (true ? 1 : 0) : 0) : 0) : 1;      // Noncompliant [[sc=11;ec=64;effortToFix=1]] {{Reduce the number of conditional operators (4) used in the expression (maximum allowed 3).}}

  int c = true || false || true || false || false;                    // Noncompliant [[effortToFix=1]]
  int d = true && false && true && false && true && true;             // Noncompliant [[effortToFix=2]] {{Reduce the number of conditional operators (5) used in the expression (maximum allowed 3).}}

  int e = true | false | true | false;                                

  void f() {
    if ((true ? 0 : 1) || false || true && false && true || false) {  // Noncompliant [[effortToFix=3]] {{Reduce the number of conditional operators (6) used in the expression (maximum allowed 3).}}
    }
  }

  void g() {
    new Foo() {                                                       
      int a = true && true;
      int b = true && true;
      int c = true && true;
      int d = true && true;
      int e = true && true;
    };
  }

  void g() {
    boolean foo = true && true && true &&                             // Noncompliant [[sc=19;ec=11;effortToFix=1]]
      new Foo() {                                                     
        int a = true && true && true && false && false;               // Noncompliant [[effortToFix=1]]
        int a2 = true && true && true;
      }.someThing() &&
      true;
  }

  int[] foo = new int[] {                                             
    true && true && true && true,                                     
    true && true && true && true && true                              // Noncompliant
  };
  String s = "ServerDef[applicationName=" + sd.applicationName +
      " serverName=" + sd.serverName +
      " serverClassPath=" + sd.serverClassPath +
      " serverArgs=" + sd. serverArgs +
      " serverVmArgs=" + sd.serverVmArgs +
      "]" ;
  ObjectInstance meth(){
    return new ObjectInstance(true && false, true ? "":"plop", true ? "":"plop", true ? "":"plop"); // Noncompliant
  }
}
