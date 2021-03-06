/**	
 *  Copyright (c) 2005-2014 VedantaTree all rights reserved.
 * 
 *  This file is part of ExpressionOasis.
 *
 *  ExpressionOasis is free software. You can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ExpressionOasis is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT SHALL 
 *  THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES 
 *  OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 *  ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE 
 *  OR OTHER DEALINGS IN THE SOFTWARE.See the GNU Lesser General Public License 
 *  for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ExpressionOasis. If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Please consider to contribute any enhancements to upstream codebase. 
 *  It will help the community in getting improved code and features, and 
 *  may help you to get the later releases with your changes.
 */
package org.vedantatree.expressionoasis.expressions.arithmatic;

import org.vedantatree.expressionoasis.exceptions.ExpressionEngineException;
import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.types.Type;
import org.vedantatree.expressionoasis.types.ValueObject;


/**
 * This is the expression to perform addition.
 * 
 * @author Parmod Kamboj
 * @author Mohit Gupta
 * @version 1.0
 * 
 *          Added support for nulls
 * 
 * @author Kris Marwood
 * @version 1.1
 */
public class AddExpression extends BinaryOperatorExpression
{

	static
	{
		addTypePair( AddExpression.class, Type.LONG, Type.LONG, Type.LONG );
		addTypePair( AddExpression.class, Type.DOUBLE, Type.DOUBLE, Type.DOUBLE );
		addTypePair( AddExpression.class, Type.STRING, Type.STRING, Type.STRING );
		addTypePair( AddExpression.class, Type.LONG, Type.DOUBLE, Type.DOUBLE );
		addTypePair( AddExpression.class, Type.LONG, Type.STRING, Type.STRING );
		addTypePair( AddExpression.class, Type.DOUBLE, Type.LONG, Type.DOUBLE );
		addTypePair( AddExpression.class, Type.DOUBLE, Type.STRING, Type.STRING );
		addTypePair( AddExpression.class, Type.STRING, Type.DOUBLE, Type.STRING );
		addTypePair( AddExpression.class, Type.STRING, Type.LONG, Type.STRING );

		addTypePair( AddExpression.class, Type.LONG, Type.INTEGER, Type.LONG );
		addTypePair( AddExpression.class, Type.INTEGER, Type.LONG, Type.LONG );
		addTypePair( AddExpression.class, Type.BOOLEAN, Type.STRING, Type.STRING );
		addTypePair( AddExpression.class, Type.STRING, Type.BOOLEAN, Type.STRING );

		// nullable type support
		addTypePair( AddExpression.class, Type.OBJECT, Type.OBJECT, Type.OBJECT );
		addTypePair( AddExpression.class, Type.LONG, Type.OBJECT, Type.LONG );
		addTypePair( AddExpression.class, Type.OBJECT, Type.LONG, Type.LONG );
		addTypePair( AddExpression.class, Type.DOUBLE, Type.OBJECT, Type.DOUBLE );
		addTypePair( AddExpression.class, Type.OBJECT, Type.DOUBLE, Type.DOUBLE );
		addTypePair( AddExpression.class, Type.STRING, Type.OBJECT, Type.STRING );
		addTypePair( AddExpression.class, Type.OBJECT, Type.STRING, Type.STRING );

	}

	/**
	 * Gets the addition of child operands
	 * 
	 * @see org.vedantatree.expressionoasis.expressions.Expression#getValue()
	 */
	public ValueObject getValue() throws ExpressionEngineException
	{
		Object leftValue = leftOperandExpression.getValue().getValue();
		Object rightValue = rightOperandExpression.getValue().getValue();
		Object result = null;
		Type returnType = getReturnType();

		if( leftValue != null && rightValue != null )
		{
			if( returnType == Type.LONG )
			{
				result = new Long( ( (Number) leftValue ).longValue() + ( (Number) rightValue ).longValue() );
			}
			else if( returnType == Type.DOUBLE )
			{
				result = new Double( ( (Number) leftValue ).doubleValue() + ( (Number) rightValue ).doubleValue() );
			}
			else
			{
				result = leftValue.toString() + rightValue.toString();
			}
		}

		return new ValueObject( result, returnType );
	}
}