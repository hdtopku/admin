// vite.config.js
import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "file:///Users/lxh/Desktop/admin/admin-vue/node_modules/.pnpm/vite@5.2.11_sass@1.77.1/node_modules/vite/dist/node/index.js";
import AutoImport from "file:///Users/lxh/Desktop/admin/admin-vue/node_modules/.pnpm/unplugin-auto-import@0.17.6/node_modules/unplugin-auto-import/dist/vite.js";
import Components from "file:///Users/lxh/Desktop/admin/admin-vue/node_modules/.pnpm/unplugin-vue-components@0.27.0_vue@3.4.27/node_modules/unplugin-vue-components/dist/vite.js";
import { ElementPlusResolver } from "file:///Users/lxh/Desktop/admin/admin-vue/node_modules/.pnpm/unplugin-vue-components@0.27.0_vue@3.4.27/node_modules/unplugin-vue-components/dist/resolvers.js";
import Vue from "file:///Users/lxh/Desktop/admin/admin-vue/node_modules/.pnpm/@vitejs+plugin-vue@5.0.4_vite@5.2.11+vue@3.4.27/node_modules/@vitejs/plugin-vue/dist/index.mjs";
var __vite_injected_original_import_meta_url = "file:///Users/lxh/Desktop/admin/admin-vue/vite.config.js";
var vite_config_default = defineConfig({
  plugins: [
    Vue(),
    // 按需导入，自动导入
    AutoImport({
      resolvers: [ElementPlusResolver()]
    }),
    Components({
      resolvers: [ElementPlusResolver()]
    })
  ],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", __vite_injected_original_import_meta_url))
    }
  },
  server: {
    port: 3e3,
    proxy: {
      "/api": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, "")
      }
    }
  }
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcuanMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCIvVXNlcnMvbHhoL0Rlc2t0b3AvYWRtaW4vYWRtaW4tdnVlXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ZpbGVuYW1lID0gXCIvVXNlcnMvbHhoL0Rlc2t0b3AvYWRtaW4vYWRtaW4tdnVlL3ZpdGUuY29uZmlnLmpzXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ltcG9ydF9tZXRhX3VybCA9IFwiZmlsZTovLy9Vc2Vycy9seGgvRGVza3RvcC9hZG1pbi9hZG1pbi12dWUvdml0ZS5jb25maWcuanNcIjtpbXBvcnQge2ZpbGVVUkxUb1BhdGgsIFVSTH0gZnJvbSAnbm9kZTp1cmwnXG5cbmltcG9ydCB7ZGVmaW5lQ29uZmlnfSBmcm9tICd2aXRlJ1xuaW1wb3J0IEF1dG9JbXBvcnQgZnJvbSAndW5wbHVnaW4tYXV0by1pbXBvcnQvdml0ZSdcbmltcG9ydCBDb21wb25lbnRzIGZyb20gJ3VucGx1Z2luLXZ1ZS1jb21wb25lbnRzL3ZpdGUnXG5pbXBvcnQge0VsZW1lbnRQbHVzUmVzb2x2ZXJ9IGZyb20gJ3VucGx1Z2luLXZ1ZS1jb21wb25lbnRzL3Jlc29sdmVycydcbmltcG9ydCBWdWUgZnJvbSAnQHZpdGVqcy9wbHVnaW4tdnVlJ1xuXG4vLyBodHRwczovL3ZpdGVqcy5kZXYvY29uZmlnL1xuZXhwb3J0IGRlZmF1bHQgZGVmaW5lQ29uZmlnKHtcbiAgICBwbHVnaW5zOiBbXG4gICAgICAgIFZ1ZSgpLFxuICAgICAgICAvLyBcdTYzMDlcdTk3MDBcdTVCRkNcdTUxNjVcdUZGMENcdTgxRUFcdTUyQThcdTVCRkNcdTUxNjVcbiAgICAgICAgQXV0b0ltcG9ydCh7XG4gICAgICAgICAgICByZXNvbHZlcnM6IFtFbGVtZW50UGx1c1Jlc29sdmVyKCldLFxuICAgICAgICB9KSxcbiAgICAgICAgQ29tcG9uZW50cyh7XG4gICAgICAgICAgICByZXNvbHZlcnM6IFtFbGVtZW50UGx1c1Jlc29sdmVyKCldLFxuICAgICAgICB9KSxcbiAgICBdLFxuICAgIHJlc29sdmU6IHtcbiAgICAgICAgYWxpYXM6IHtcbiAgICAgICAgICAgICdAJzogZmlsZVVSTFRvUGF0aChuZXcgVVJMKCcuL3NyYycsIGltcG9ydC5tZXRhLnVybCkpXG4gICAgICAgIH1cbiAgICB9LFxuICAgIHNlcnZlcjoge1xuICAgICAgICBwb3J0OiAzMDAwLFxuICAgICAgICBwcm94eToge1xuICAgICAgICAgICAgJy9hcGknOiB7XG4gICAgICAgICAgICAgICAgdGFyZ2V0OiAnaHR0cDovL2xvY2FsaG9zdDo4MDgwLycsXG4gICAgICAgICAgICAgICAgY2hhbmdlT3JpZ2luOiB0cnVlLFxuICAgICAgICAgICAgICAgIHJld3JpdGU6IChwYXRoKSA9PiBwYXRoLnJlcGxhY2UoL15cXC9hcGkvLCAnJylcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSxcbiAgICB9LFxufSlcbiJdLAogICJtYXBwaW5ncyI6ICI7QUFBd1IsU0FBUSxlQUFlLFdBQVU7QUFFelQsU0FBUSxvQkFBbUI7QUFDM0IsT0FBTyxnQkFBZ0I7QUFDdkIsT0FBTyxnQkFBZ0I7QUFDdkIsU0FBUSwyQkFBMEI7QUFDbEMsT0FBTyxTQUFTO0FBTjRKLElBQU0sMkNBQTJDO0FBUzdOLElBQU8sc0JBQVEsYUFBYTtBQUFBLEVBQ3hCLFNBQVM7QUFBQSxJQUNMLElBQUk7QUFBQTtBQUFBLElBRUosV0FBVztBQUFBLE1BQ1AsV0FBVyxDQUFDLG9CQUFvQixDQUFDO0FBQUEsSUFDckMsQ0FBQztBQUFBLElBQ0QsV0FBVztBQUFBLE1BQ1AsV0FBVyxDQUFDLG9CQUFvQixDQUFDO0FBQUEsSUFDckMsQ0FBQztBQUFBLEVBQ0w7QUFBQSxFQUNBLFNBQVM7QUFBQSxJQUNMLE9BQU87QUFBQSxNQUNILEtBQUssY0FBYyxJQUFJLElBQUksU0FBUyx3Q0FBZSxDQUFDO0FBQUEsSUFDeEQ7QUFBQSxFQUNKO0FBQUEsRUFDQSxRQUFRO0FBQUEsSUFDSixNQUFNO0FBQUEsSUFDTixPQUFPO0FBQUEsTUFDSCxRQUFRO0FBQUEsUUFDSixRQUFRO0FBQUEsUUFDUixjQUFjO0FBQUEsUUFDZCxTQUFTLENBQUMsU0FBUyxLQUFLLFFBQVEsVUFBVSxFQUFFO0FBQUEsTUFDaEQ7QUFBQSxJQUNKO0FBQUEsRUFDSjtBQUNKLENBQUM7IiwKICAibmFtZXMiOiBbXQp9Cg==
