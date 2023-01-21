# DiamondPenalty Minecraft 1.19.3 plugin

This plugin adds a penalty for mining diamonds. 
When a player has permission `diamondpenalty.penalty` and mines a diamond, the plugin adds a chance to replace diamond with coal.
Default chance is 0.5 and can be changed in config.yml.

## Commands

`/diamondpenalty reload` - Reloads config.yml

## Permissions

`diamondpenalty.bypass` - Bypasses the penalty, even if the player has `diamondpenalty.penalty`

`diamondpenalty.penalty` - Allows player to mine diamonds with a chance to get coal instead

`diamondpenalty.reload` - Allows player to use `/diamondpenalty reload` command

## Config

```yaml
# Chance to get coal instead of diamond
# Default: 0.5
penalty-chance: 0.5
```