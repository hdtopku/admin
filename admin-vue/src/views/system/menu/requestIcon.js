const iconsVite = import.meta.glob('../../../assets/icons/**/*.svg')
const icons = []
const re = /\.\/(.*)\.svg/
for (const icon in iconsVite) {
    const name = icon.match(re)[1].substring(icon.match(re)[1].lastIndexOf('/') + 1)
    icons.push(name)
}
export default icons