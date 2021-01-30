import React from 'react'

const withClass = (WrappedComponent, className) => {
    return props=> {
       return <div className={className}>
            <WrappedComponent {...props}/>
        </div>
    };
}

// const withClass = props =>{
//     return <div className={props.classes}>
//         {props.children}
//     </div>
// }

export default withClass;