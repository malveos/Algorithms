import React from 'react'

const ValidationComponent = (props) => {
    let op = 'Text Less than 5';
    if(props.length >4){
        op = 'Text is long enough';
    }
return <div>{op}</div>
}

export default ValidationComponent