import React, { Component } from 'react';
import { connect } from 'react-redux';

import CounterControl from '../../components/CounterControl/CounterControl';
import CounterOutput from '../../components/CounterOutput/CounterOutput';
import * as actionCreators from '../../store/actions/index';

class Counter extends Component {
    render() {
        return (
            <div>
                <CounterOutput value={this.props.ctr} />
                <CounterControl label="Increment" clicked={this.props.onIncr} />
                <CounterControl label="Decrement" clicked={this.props.onDecr} />
                <CounterControl label="Add 5" clicked={this.props.add5} />
                <CounterControl label="Subtract 5" clicked={this.props.sub5} />
                <hr />
                <button onClick={() => this.props.strRes(this.props.ctr)}>Store Result</button>
                <ol style={{liststyletype: 'square'}}>
                    {this.props.results.map(r => {
                        return <li key={r.id} onClick={() => this.props.delRes(r.id)}> {r.val}</li>
                    })}
                </ol>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        ctr: state.ctr.counter,
        results: state.res.results
    };
}

const mapDispatchToProps = dispatch => {
    return {
        onIncr: () => dispatch(actionCreators.increment()),
        onDecr: () => dispatch(actionCreators.decrement()),
        add5: () => dispatch(actionCreators.add(5)),
        sub5: () => dispatch(actionCreators.subtract(5)),
        strRes: (result) => dispatch(actionCreators.storeResult(result)),
        delRes: (id) => dispatch(actionCreators.deleteResult(id))
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Counter);