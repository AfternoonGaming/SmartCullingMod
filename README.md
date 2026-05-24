# Smart Culling Mod

A high-performance optimization mod for Minecraft 26.x that implements intelligent block culling to improve rendering performance.

## Features

- **Smart Block Culling**: Intelligently culls blocks that are not visible
- **Opaque Full Cube Detection**: Uses Minecraft's built-in opacity detection
- **Full Enclosure Culling**: Removes completely enclosed blocks from rendering pipeline
- **Performance Boost**: Significantly reduces unnecessary rendering calls

## Specifications

- **Minecraft Version**: 26.x (26.1+)
- **Fabric Loader**: 0.19.2+
- **Fabric API**: 0.106.0+
- **Java Version**: 21
- **Mod Version**: 1.0.0

## Installation

1. Download the mod JAR from releases
2. Place it in `.minecraft/mods` folder
3. Ensure Fabric Loader 0.19.2+ is installed
4. Launch Minecraft with Fabric profile

## Building from Source

### Requirements
- JDK 21 or higher
- Gradle

### Build Command
```bash
./gradlew build
```

The compiled JAR will be created in `build/libs/smartculling-1.0.0.jar`

## How It Works

The Smart Culling mod uses Mixins to inject optimization logic into Minecraft's rendering system:

1. **Block State Analysis**: Analyzes each block's material properties
2. **Neighbor Detection**: Checks adjacent blocks for opacity
3. **Occlusion Culling**: Removes hidden faces from rendering
4. **Full Enclosure Culling**: Culls entire blocks when completely surrounded by solid blocks

## Minecraft 26.x Compatibility

This mod is fully compatible with Minecraft 26.x and uses modern Fabric APIs:
- Uses `BlockState.isOpaqueFullCube()` for reliable culling
- Compatible with Fabric Loader 0.19.2+
- Tested with Fabric API 0.106.0+

## Performance Impact

- Reduced chunk rebuild time
- Lower GPU memory usage
- Improved FPS in chunk-heavy areas
- Minimal CPU overhead

## License

MIT License - See LICENSE file for details

## Author

AfternoonGaming

## Support

For issues, please report on GitHub Issues page.
