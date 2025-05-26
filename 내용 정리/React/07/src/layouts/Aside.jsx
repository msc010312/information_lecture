const Aside = ({asideLink=[]}) => {
    return (
        <div className="aside">
            <ul>
                {asideLink.length>0 && asideLink.map((item,index)=>{
                    return (
                        <li key={index}><a href={item.href}>{item.title}</a></li>
                    )
                })}
            </ul>
        </div>
    );
}
export default Aside;