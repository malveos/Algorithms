import React from "react";
import CSSTransition from 'react-transition-group/CSSTransition' //need extra property classNames

import "./Modal.css";

const modal = props => {
  const cssClasses = [
    "Modal",
    props.show === 'entering' ? "ModalOpen" : props.show === "exiting" ? "ModalClosed" : null
  ];

  return (
    <div>
      <CSSTransition
        timeout={600}
        classNames={{
          enter: '',
          enterActive: 'ModalOpen',
          exit: '',
          exitActive: ''
        }}>
        <div className={cssClasses.join(' ')}>
          <h1>A Modal</h1>
          <button className="Button" onClick={props.closed}> Dismiss </button>
        </div>
      </CSSTransition>
    </div>
  );
};

export default modal;
