const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootpfcf09i8/",
            name: "springbootpfcf09i8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootpfcf09i8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot与Vue.js的健康管理系统"
        } 
    }
}
export default base
