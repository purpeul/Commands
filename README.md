# Commands
 
```java
        ColorCommands.getInstance().register("hello")
                .asBasic()
                .with(new Parameter("pseudo", true, Parameters.PLAYER))
                .build((sender, args) -> 
                        Bukkit.broadcastMessage("§7" + sender.getName() + " : Bonjour ! " + args.get(0, String.class)));
```
