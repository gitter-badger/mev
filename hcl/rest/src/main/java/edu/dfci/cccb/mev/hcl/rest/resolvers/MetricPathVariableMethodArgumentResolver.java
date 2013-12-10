/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.dfci.cccb.mev.hcl.rest.resolvers;

import static java.lang.Integer.MAX_VALUE;

import java.util.Collection;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMethodArgumentResolver;

import edu.dfci.cccb.mev.hcl.domain.contract.InvalidMetricException;
import edu.dfci.cccb.mev.hcl.domain.contract.Metric;

/**
 * @author levk
 * 
 */
public class MetricPathVariableMethodArgumentResolver extends PathVariableMethodArgumentResolver implements Ordered {

  private @Getter @Setter (onMethod = @_ (@Inject)) Collection<Metric> metrics;
  private @Getter @Setter int order = MAX_VALUE;

  /* (non-Javadoc)
   * @see org.springframework.web.servlet.mvc.method.annotation.
   * PathVariableMethodArgumentResolver
   * #supportsParameter(org.springframework.core.MethodParameter) */
  @Override
  public boolean supportsParameter (MethodParameter parameter) {
    return Metric.class.isAssignableFrom (parameter.getParameterType ()) && super.supportsParameter (parameter);
  }

  /* (non-Javadoc)
   * @see org.springframework.web.servlet.mvc.method.annotation.
   * PathVariableMethodArgumentResolver#resolveName(java.lang.String,
   * org.springframework.core.MethodParameter,
   * org.springframework.web.context.request.NativeWebRequest) */
  @Override
  protected Object resolveName (String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
    Object value = super.resolveName (name, parameter, request);
    if (value == null)
      return null;
    for (Metric metric : metrics)
      if (metric.name ().equals (value))
        return metric;
    throw new InvalidMetricException ().name (value.toString ());
  }
}
