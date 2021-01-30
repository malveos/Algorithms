import React from 'react'
import classes from './Modal.css'
import Aux from '../../../hoc/AuxFile/Auxile'
import Backdrop from '../Backdrop/Backdrop'

const modal = props => {

    // shouldComponentUpdate(nextProps, nextState) {
    //     return (nextProps.show !== props.show || nextProps.children !== props.children);
    // }
    return <Aux>
        <Backdrop show={props.show} clicked={props.modalClosed} />
        <div className={classes.Modal}
            style={{
                transform: props.show ? 'transformY(0)' : 'transformY(-100vh)',
                opacity: props.show ? '1' : '0',
                display: props.show ? 'inline' : 'none'
            }}>
            {props.children}
        </div>
    </Aux>

};

export default React.memo(modal, (prevProps, nextProps) =>
    (nextProps.show === prevProps.show && nextProps.children === prevProps.children));