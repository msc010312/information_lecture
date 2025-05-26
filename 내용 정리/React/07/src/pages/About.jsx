import Layout from "../layouts/Layout";
const About = () => {
    const asideLink = [
        {title:"회사소개",href:"/about/1"},
        {title:"연혁",href:"/about/2"},
        {title:"팀 소개",href:"/about/3"},
        {title:"오시는길",href:"/about/4"},
    ];
     return (
        <Layout showAside={true} asideLink={asideLink}>
            <h1>about</h1>
            <p>about page의 메인영역입니다</p>
        </Layout>
    );
}
export default About;