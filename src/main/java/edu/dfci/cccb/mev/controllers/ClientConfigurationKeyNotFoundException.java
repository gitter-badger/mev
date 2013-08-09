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
package edu.dfci.cccb.mev.controllers;

import lombok.Getter;

/**
 * @author levk
 *
 */
// TODO: Attach internationalization
public class ClientConfigurationKeyNotFoundException extends Exception {
  private static final long serialVersionUID = 1L;

  private final @Getter String key;
  
  public ClientConfigurationKeyNotFoundException (String key) {
    super ("Configuration key " + key + " not found");
    this.key = key;
  }
  
  /* (non-Javadoc)
   * @see java.lang.Throwable#getLocalizedMessage()
   */
  @Override
  public String getLocalizedMessage () {
    return getMessage ();
  }
}