# Commands Systems

## Get Started

```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
  
dependencies {
  implementation 'com.github.purpeul:Commands:0.4-alpha'
}
```

## Make your first command

```java
ColorCommands.getInstance().register("hello")
   .asBasic()
   .with(new Parameter("pseudo", true, Parameters.PLAYER))
   .build((sender, args) -> 
       Bukkit.broadcastMessage("§7" + sender.getName() + " : Bonjour ! " + args.get(0, String.class))
     );
```
