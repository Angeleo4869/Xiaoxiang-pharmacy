import React from 'react';
import { MemoryRouter as Router } from 'react-router';
import { Link as RouterLink } from 'react-router-dom';
import Link from '@material-ui/core/Link';
import App from './../norms'
// The use of React.forwardRef will no longer be required for react-router-dom v6.
// See https://github.com/ReactTraining/react-router/issues/6056
const Link1 = React.forwardRef((props, ref) => <RouterLink innerRef={ref} {...props} />);

const Link2 = React.forwardRef((props, ref) => (
  <RouterLink innerRef={ref} to="/../norms" {...props} />
));

export default function LinkRouter() {
  return (
    <Router>
      <div>
        <Link component={Link1} to="/norms">
          With prop forwarding
        </Link>
        <br />
        <Link component={App}>Without prop forwarding</Link>
        <a href="/../norms">123</a>
        <route path="/norms">
          {App}
        </route>
      </div>
    </Router>
  );
}