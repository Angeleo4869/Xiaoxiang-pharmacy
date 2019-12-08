import React from 'react';
import PropTypes from 'prop-types';

class RouteComp2 extends React.Component{
  render(){
    return(
        <div>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </div>
    )
  };
}
RouteComp2.propTypes = {
  name: PropTypes.string
};

RouteComp2.defaultProps = {
  name: 'javaEE'
}
export default RouteComp2;
