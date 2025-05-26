import Header from "./Header";
import Footer from "./Footer";
import Aside from "./Aside";
import Section from "./Section";
import './css/layout.css'
const Layout = ({children,showAside,asideLink}) => {
    return (
        <div className="">
            <Header></Header>
            <main>
                {showAside && <Aside asideLink={asideLink}/>}
                <Section>
                    {children}
                </Section>
            </main>
            <Footer></Footer>
        </div>
    );
}
export default Layout;