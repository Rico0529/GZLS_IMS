const base = {
    get() {
        return {
            url : "http://localhost:8080/GZLS_IMS/",
            name: "GZLS_IMS",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/GZLS_IMS/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的广州市劳动与社会保障信息管理系统的设计与实现"
        } 
    }
}
export default base
