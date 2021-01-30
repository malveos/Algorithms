import React from 'react';

import useHttpErrorHandler from '../../hooks/http-error-handler';
import Modal from '../../components/UI/Modal/Modal';
import Aux from '../AuxFile/Auxile';

const withErrorHandler = (WrappedComp, axios) => {
    return props => {
        const [err, clearError] = useHttpErrorHandler(axios);

        return <Aux>
            <Modal
                show={err}
                modalClosed={clearError} >
                {err ? err.message : null}</Modal>
            <WrappedComp {...props} />
        </Aux>;
    };
}

export default withErrorHandler;